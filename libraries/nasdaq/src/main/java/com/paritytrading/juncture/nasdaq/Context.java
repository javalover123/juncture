package com.paritytrading.juncture.nasdaq;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import com.paritytrading.juncture.nasdaq.nls30.NLS30;
import com.paritytrading.juncture.nasdaq.nls30.NLS30Parser;
import com.paritytrading.juncture.nasdaq.nls30.NLS30Source;
import com.paritytrading.juncture.nasdaq.qbbo21.QBBO21;
import com.paritytrading.juncture.nasdaq.qbbo21.QBBO21.Message;
import com.paritytrading.juncture.nasdaq.qbbo21.QBBO21Parser;
import com.paritytrading.juncture.nasdaq.qbbo21.QBBO21Source;

/**
 * Thread safe for multi channel decode.
 *
 * <pre>
 * private static final ThreadLocal<Context> CONTEXT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new Context());
 * </pre>
 *
 * @author javalover123
 * @date 2022/3/18
 */
public class Context {

    private Message qbboMessage = null;

    private QBBO21Parser qbbo21Parser = new QBBO21Parser(new QBBO21Source() {
        @Override
        protected void handle(Message message) {
            qbboMessage = message;
        }
    });

    private NLS30.Message nlsMessage = null;

    private NLS30Parser nls30Parser = new NLS30Parser(new NLS30Source() {
        @Override
        protected void handle(NLS30.Message message) {
            nlsMessage = message;
        }
    });

    private final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    private FileChannel nlspOut;

    private FileChannel qbboOut;

    {
        NLS30.setDecodeContainsHeader(false);
        QBBO21.setDecodeContainsHeader(false);
        try {
            /*nlspOut = new FileOutputStream(String.format("quote.us_nlsp_%d_%d.bin", Thread.currentThread().getId(),
                    System.currentTimeMillis())).getChannel();
            qbboOut = new FileOutputStream(String.format("quote.us_qbbo_%d_%d.bin", Thread.currentThread().getId(),
                    System.currentTimeMillis())).getChannel();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Message getQbboMessage() {
        return qbboMessage;
    }

    public QBBO21Parser getQbbo21Parser() {
        return qbbo21Parser;
    }

    public NLS30.Message getNlsMessage() {
        return nlsMessage;
    }

    public NLS30Parser getNls30Parser() {
        return nls30Parser;
    }

    public ByteBuffer getByteBuffer() {
        return byteBuffer;
    }

    public FileChannel getNlspOut() {
        return nlspOut;
    }

    public FileChannel getQbboOut() {
        return qbboOut;
    }

}
