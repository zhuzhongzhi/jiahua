package com.xgit.iot.service.system;

import com.xgit.iot.dao.mapper.system.SysSequenceMapper;
import com.xgit.iot.infra.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SysSequenceService {

    @Autowired
    private SysSequenceMapper sysSequenceMapper;

    public Integer getSeqByCode(Integer code){
        Integer seq = sysSequenceMapper.getSeqByCode(code);
        return seq;
    }

    @Transactional(rollbackFor = Exception.class)
    public ErrorCode updateSeqByCode(Integer code, Integer no){
        int ret = sysSequenceMapper.updateSeqByCode(code,no);
        if(ret == 0){
            return ErrorCode.Failure;
        }
        return ErrorCode.Success;
    }

    @Transactional(rollbackFor = Exception.class)
    public void resetSequence() {
        int code = sysSequenceMapper.resetSequence();
    }
}
