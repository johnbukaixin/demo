package com.peach.demo.mina;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSessionConfig;

/**
 * Created by panta on 2017/12/8.
 */
public class SessionConfig implements IoSessionConfig {
    @Override
    public int getReadBufferSize() {
        return 0;
    }

    @Override
    public void setReadBufferSize(int readBufferSize) {

    }

    @Override
    public int getMinReadBufferSize() {
        return 0;
    }

    @Override
    public void setMinReadBufferSize(int minReadBufferSize) {

    }

    @Override
    public int getMaxReadBufferSize() {
        return 0;
    }

    @Override
    public void setMaxReadBufferSize(int maxReadBufferSize) {

    }

    @Override
    public int getThroughputCalculationInterval() {
        return 0;
    }

    @Override
    public long getThroughputCalculationIntervalInMillis() {
        return 0;
    }

    @Override
    public void setThroughputCalculationInterval(int throughputCalculationInterval) {

    }

    @Override
    public int getIdleTime(IdleStatus status) {
        return 0;
    }

    @Override
    public long getIdleTimeInMillis(IdleStatus status) {
        return 0;
    }

    @Override
    public void setIdleTime(IdleStatus status, int idleTime) {

    }

    @Override
    public int getReaderIdleTime() {
        return 0;
    }

    @Override
    public long getReaderIdleTimeInMillis() {
        return 0;
    }

    @Override
    public void setReaderIdleTime(int idleTime) {

    }

    @Override
    public int getWriterIdleTime() {
        return 0;
    }

    @Override
    public long getWriterIdleTimeInMillis() {
        return 0;
    }

    @Override
    public void setWriterIdleTime(int idleTime) {

    }

    @Override
    public int getBothIdleTime() {
        return 0;
    }

    @Override
    public long getBothIdleTimeInMillis() {
        return 0;
    }

    @Override
    public void setBothIdleTime(int idleTime) {

    }

    @Override
    public int getWriteTimeout() {
        return 0;
    }

    @Override
    public long getWriteTimeoutInMillis() {
        return 0;
    }

    @Override
    public void setWriteTimeout(int writeTimeout) {

    }

    @Override
    public boolean isUseReadOperation() {
        return false;
    }

    @Override
    public void setUseReadOperation(boolean useReadOperation) {

    }

    @Override
    public void setAll(IoSessionConfig config) {

    }
}
