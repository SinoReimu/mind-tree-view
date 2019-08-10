package cn.tecotaku.mindtree.core.data;

public class LooperFlag<T>  {

    private T[] loopBody;
    private LooperListener<T> mListener;
    private int point = 0;

    public LooperFlag(T[] loopBody, LooperListener<T> listener) {
        this.loopBody = loopBody;
        mListener = listener;
    }

    public T next() {
        point += 1;
        if (point == loopBody.length) {
            point = 0;
        }

        if (mListener != null) {
            mListener.onLooper(loopBody[point]);
        }

        return loopBody[point];
    }

    public void setLooperListener(LooperListener<T> listener) {
        mListener = listener;
    }

    public interface LooperListener<T> {
        void onLooper(T item);
    }
}
