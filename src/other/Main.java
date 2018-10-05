//import cn.bmob.javacloud.stub.*;
//import cn.bmob.javacloud.stub.CloudHandler.*;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.printf("hello world!");
//    }
//
//    //onRequest
//    public static void onRequest(final Request request, final Response response, final Modules modules) throws Throwable {
//        final String ROLE = "role";
//        final String USER = "user";
//        final String USERID = "userid";
//        final String ACTION = "action";
//        final String RESULT = "result";
//        final String TRY = "try";
//        final String CANCEL = "cancel";
//        final String FETCH = "fetch";
//        final String ORDERID = "orderid";
//        final String MSG = "msg";
//        final String PARAMS_NOT_FOUND = "Params Not Found";
//        final String FORBIDDEN = "Forbidden";
//        final String SUCCESS = "success";
//        final String YES = "yes";
//        final String NO = "no";
//        final String OFFER = "offer";
//        final String OBJECTID = "objectId";
//        final Integer STATE_START = 1;
//        final Integer STATE_CREATE =0;
//        final Integer STATE_PAUSE = 2;
//        final Integer STATE_END =3;
//        final Integer STATE_UNPAY = 4;
//        final Integer STATE_PAYED = 5;
//
//        JSONObject params = request.getQueryParams();
//
//        if(params.isEmpty()) {
//            response.send(JSON.toJson(MSG, PARAMS_NOT_FOUND, SUCCESS, NO), 404, PARAMS_NOT_FOUND);
//            return;
//        }
//
//        if(!params.containsKey(ROLE) || !params.containsKey(USERID)) {
//            response.send(JSON.toJson(MSG, PARAMS_NOT_FOUND, SUCCESS, NO), 404, PARAMS_NOT_FOUND);
//            return;
//        }
//
//        String role = (String) params.get(ROLE);
//        String userid = (String) params.get(USERID);
//
//        if(role.equals(USER)) {
//            if(!params.containsKey(USERID) || !params.containsKey(ACTION)) {
//                response.send(JSON.toJson("msg", "no params", "success", "no"), 404, "NotFound");
//                return;
//            }
//
//            String action = params.getString(ACTION);
//
//            boolean checkUser = false;
//            boolean givenMargin = false;
//            //查看用户是否存在
//            Querier userQuerier = new Querier("invite_log").addWhereEqualTo(USERID, userid);
//
//            HttpResponse userRes = modules.oData.find(userQuerier);
//
//            if(userRes.queryResults.size() != 0) {
//                checkUser = true;
//            }
//
//            if(!checkUser) {
//                response.send(JSON.toJson("msg", "forbidden", "success", "no"), 403, "forbidden");
//                return;
//            }
//
//            //todo
//            if(action.equals(TRY)) {
//                //查看报价参数是否存在
//                if(!params.containsKey(ORDERID) || !params.containsKey(OFFER)) {
//                    response.send(JSON.toJson("msg", "prams not found", "success", "no"), 404, "failed");
//                    return;
//                }
//
//                String orderid = params.getString(ORDERID);
//
//                //判断订单是否存在，如果订单不存在，返回错误
//                boolean orderExist = false;
//                HttpResponse checkOrderRes = modules.oData.findOne("auctionOrders", orderid);
//                if(checkOrderRes.res.code==200) {
//                    orderExist = true;
//                }
//
//                if(!orderExist) {
//                    response.send(JSON.toJson("msg", "Order Not Found", "success", "no"), 404, "Order Not Found");
//                    return;
//                }
//
//                //查看用户是否缴纳保证金
//                Querier marginQuerier = new Querier("marginRecords").addWhereEqualTo(USERID, userid).addWhereEqualTo(ORDERID, orderid);
//                HttpResponse marginRes = modules.oData.find(marginQuerier);
//                if(marginRes.queryResults.size() != 0) {
//                    givenMargin = true;
//                }
//
//                if(!givenMargin) {
//                    response.send(JSON.toJson("msg", "No margin",    "success", "no"), 403, "forbidden");
//                    return;
//                }
//
//
//
//                //检查订单时间有没有到，如果时间到了，就返回失败，如果没有到，判断是不是只剩五分钟，如果是的，就把时间顺延五分钟，然后继续
//                JSONObject orderInfo = checkOrderRes.jsonData;
//                Date current = new Date();
//                if(current.before(orderInfo.getJSONObject("startTime").getDate("iso")) || current.after(orderInfo.getJSONObject("endTime").getDate("iso"))) {
//                    response.send(JSON.toJson("msg", "Time Expired",    "success", "no"), 403, "forbidden");
//                    return;
//                }
//
//
//                //error
//                if((orderInfo.getJSONObject("endTime").getDate("iso").getTime() - current.getTime()) < (5*60*1000)) {
//                    //更新订单表
//                    Date happydate = new Date(orderInfo.getJSONObject("endTime").getDate("iso").getTime() + 5*60*1000);
//                    String upTime = (happydate.getYear()+1900) + "-" + happydate.getMonth() + "-" + happydate.getDate() + " " + happydate.getHours()+":"+happydate.getMinutes()+":"+happydate.getSeconds();
//                    JSONObject updateInfo = new JSONObject();
//                    updateInfo.put("endTime", happydate.getTime());
//                    HttpResponse resss = modules.oData.update("auctionOrders", orderid, updateInfo);
//
//                    response.send(JSON.toJson("msg", "debug1", "time", upTime, "resss", resss,    "success", "no"), 403, "forbidden");
//                }
//                //error
//
//                Long offer = params.getLong(OFFER);
//                //查看用户出价记录，最新的价格是否是比报价低
//                Querier pricePoolQuerier = new Querier("auctionPool").addWhereEqualTo(ORDERID, orderid).order("createAt");
//                HttpResponse ppRes = modules.oData.find(pricePoolQuerier);
//                if(ppRes.jsonData.getJSONArray(RESULT).size() != 0) {
//                    if(ppRes.jsonData.getJSONArray(RESULT).getJSONObject(0).getLong(OFFER) > offer) {
//                        response.send(JSON.toJson("msg", "offer failed", "success", "no"), 404, "failed");
//                        return;
//                    } else {
//                        modules.oData.insert("auctionPool", JSON.toJson(ORDERID, orderid, USERID, userid, OFFER, offer));
//                        modules.oData.update("auctionOrders", orderid, JSON.toJson("buyId", userid));
//                    }
//                } else {
//                    modules.oData.insert("auctionPool", JSON.toJson(ORDERID, orderid, USERID, userid, OFFER, offer));
//                    modules.oData.update("auctionOrders", orderid, JSON.toJson("buyId", userid));
//                }
//                response.send(JSON.toJson("msg", "offer succ", "success", "yes", "offer", offer, "orderid", orderid), 200, "failed");
//                return;
//
//            } else if(action.equals(FETCH)) {
//                Querier orderlistQuerier = new Querier("auctionOrders").order("createdAt");
//                HttpResponse oqRes = modules.oData.find(orderlistQuerier);
//                JSONArray orderlist = oqRes.queryResults;
//
//                for (int i = 0; i < orderlist.size(); i++) {
//                    HttpResponse resultRes = modules.oData.findOne("auctionGoods",orderlist.getJSONObject(i).getString("goodsId"));
//                    orderlist.getJSONObject(i).put("goods", resultRes.jsonData);
//                }
//
//                for (int i = 0; i < orderlist.size(); i++) {
//                    Date current = new Date();
//                    JSONObject order = orderlist.getJSONObject(i);
//                    // response.send(JSON.toJson("msg", "", "success", "no"), 403, "forbidden");
//                    if(order.getJSONObject("startTime").getDate("iso").after(current)) {
//                        orderlist.getJSONObject(i).put("state", "未开始");
//                    } else if(order.getJSONObject("endTime").getDate("iso").before(current)) {
//                        Integer orderState = order.getInteger("orderState");
//                        if(orderState == STATE_PAYED){
//                            orderlist.getJSONObject(i).put("state", "已结束");
//                        } else if(orderState == STATE_UNPAY){
//                            orderlist.getJSONObject(i).put("state", "已流拍");
//                        }else {
//                            orderlist.getJSONObject(i).put("state", "失效订单");
//                        }
//                    } else {
//                        orderlist.getJSONObject(i).put("state", "进行中");
//                    }
//                }
//
//
//                response.send(JSON.toJson("msg", "fetch succ", "success", "yes", "orderlist", orderlist), 200, "failed");
//                return;
//
//            }
//
//            response.send(JSON.toJson("msg", "failed", "success", "no"), 404, "failed");
//            return;
//        }
//    }
//
////
////    //getAuctionList
////    public static void onRequest(final Request request, final Response response, final Modules modules) throws Throwable {
////        final String ROLE = "role";
////        final String ADMIN = "admin";
////        final String USER = "user";
////        final String USERID = "userid";
////        final String ACTION = "action";
////        final String CREATE = "create";
////        final String START = "start";
////        final String PAUSE = "pause";
////        final String END = "end";
////        final String GOODSID = "goodsid";
////        final String RESULT = "result";
////        final String TRY = "try";
////        final String CANCEL = "cancel";
////        final String ORDERID = "orderid";
////        final String MSG = "msg";
////        final String PARAMS_NOT_FOUND = "Params Not Found";
////        final String FORBIDDEN = "Forbidden";
////        final String SUCCESS = "success";
////        final String YES = "yes";
////        final String NO = "no";
////        final Integer STATE_START = 1;
////        final Integer STATE_CREATE =0;
////        final Integer STATE_PAUSE = 2;
////        final Integer STATE_END =3;
////        final Integer STATE_UNPAY = 4;
////        final Integer STATE_PAYED = 5;
////        final String QUOTE = "quote";
////
////        JSONObject params = request.getQueryParams();
////
////        //执行非空检查
////        if(params.isEmpty() || !params.containsKey(ROLE)) {
////            response.send(JSON.toJson(MSG, PARAMS_NOT_FOUND, SUCCESS, NO), 404, PARAMS_NOT_FOUND);
////            return;
////        }
////
////        //查找auctionOrders表获取当前所有订单
////
////
////    }
////
//
//    //        if(role.equals(ADMIN)) {
////            //init params
////            boolean checkAdmin = false;
////
////            Querier adminQuerier = new Querier("admin").addWhereEqualTo(USERID, userid);
////
////            HttpResponse adminRes = modules.oData.find(adminQuerier);
////
////            if(adminRes.queryResults.size() != 0) {
////                checkAdmin = true;
////            }
////
////            if(!checkAdmin) {
////                response.send(JSON.toJson("msg", "forbidden", "success", "no"), 403, "forbidden");
////                return;
////            }
////
////            if(!params.containsKey(USERID) || !params.containsKey(ACTION)) {
////                response.send(JSON.toJson(MSG, PARAMS_NOT_FOUND, "success", "no"), 404, "NotFound");
////                return;
////            }
////
////            String action = (String) params.get(ACTION);
////
//////            if(action.equals(CREATE)) {
//////                if(!params.containsKey(GOODSID)) {
//////                    response.send(JSON.toJson(MSG, PARAMS_NOT_FOUND, "success", "no"), 404, "NotFound");
//////                }
//////                String goodsid = params.getString(GOODSID);
//////                //查看商品是否存在
//////                Querier goodsQuerier = new Querier("auctionGoods").addWhereEqualTo("goodsId", goodsid);
//////                HttpResponse goodsRes = modules.oData.find(goodsQuerier);
//////                if(goodsRes.queryResults.size() == 0) {
//////                    response.send(JSON.toJson(MSG, "Goods Not Found", "success", "no"), 404, "NotFound");
//////                    return;
//////                }
//////                //查看该商品是否被拍卖过
//////                Querier auctionQuerier = new Querier("auctionOrders").addWhereEqualTo("goodsId", goodsid);
//////                HttpResponse auctionRes = modules.oData.find(auctionQuerier);
//////                if(auctionRes.queryResults.size() != 0) {
//////                    response.send(JSON.toJson(MSG, "Goods Auction Exists", "success", "no"), 404, "NotFound");
//////                    return;
//////                }
//////                //todo 为商品创建订单
//////
//////                //todo 返回成功
//////            }
////            String orderid = params.getString(ORDERID);
////
////            //判断订单是否存在，如果订单不存在，返回错误
////            boolean orderExist = false;
////            Querier checkOrderQuerier = new Querier("auctionOrders").addWhereEqualTo(OBJECTID, orderid);
////            HttpResponse checkOrderRes = modules.oData.find(checkOrderQuerier);
////            if(checkOrderRes.queryResults.size() != 0) {
////                orderExist = true;
////            }
////
////            if(!orderExist) {
////                response.send(JSON.toJson("msg", "Order Not Found", "success", "no"), 404, "Order Not Found");
////                return;
////            }
////
////            //todo
////            if(action.equals(START)) {
////                //查看订单是否启动，如果启动，直接返回；如果未启动，启动任务，同时将开始时间更新
////
////            } else if(action.equals(PAUSE)) {
////                //查看订单是否启动，如果启动就将订单暂停
////            } else if(action.equals(END)) {
////                //查看订单是否终止，如果未中止就将订单终止
////            }
////            response.send(JSON.toJson("msg", "failed", "success", "no"), 404, "failed");
////            return;
////        }
//
//}
