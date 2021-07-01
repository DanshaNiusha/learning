package juc.thread.concurrency;


/**
 * 业务平台异常
 *
 * @author cuiliang
 * @date 18/7/4
 */
public class BizPlatformException extends RuntimeException {

    private int code;

    public BizPlatformException() {
    }

    public BizPlatformException(int code, String errMsg) {
        super(errMsg);
        this.code = code;
    }
    
}
