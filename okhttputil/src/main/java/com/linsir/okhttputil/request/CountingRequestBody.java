package com.linsir.okhttputil.request;

import android.support.annotation.Nullable;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * Created by linSir
 * date at 2017/8/25.
 * describe:
 */

public class CountingRequestBody extends RequestBody {

    protected RequestBody delegate;
    protected Listener listener;

    protected CountingSink countingSink;

    public CountingRequestBody(RequestBody delegate,Listener listener){
        this.delegate = delegate;
        this.listener = listener;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return delegate.contentType();
    }

    public long contentLength(){
        try{
            return delegate.contentLength();
        }catch(IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        countingSink = new CountingSink(sink);
        BufferedSink bufferedSink = Okio.buffer(countingSink);
        delegate.writeTo(bufferedSink);
        bufferedSink.flush();
    }


    protected final class CountingSink extends ForwardingSink {

        private long bytesWritten = 0;

        public CountingSink(Sink delegate){
            super(delegate);
        }

        public void write(Buffer source,long byteCount) throws IOException{
            super.write(source,byteCount);
            bytesWritten += byteCount;
            listener.onRequestProgress(bytesWritten,contentLength());
        }
    }

    public static interface Listener{
        public void onRequestProgress(long byteWritten,long contentLength);
    }

}


















