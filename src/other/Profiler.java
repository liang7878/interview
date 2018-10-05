package other;

public class Profiler {
    private static final ThreadLocal<Long> TIME = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return super.initialValue();
        }
    };
}
