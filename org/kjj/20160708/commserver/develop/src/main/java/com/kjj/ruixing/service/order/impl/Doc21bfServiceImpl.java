package com.kjj.ruixing.service.order.impl;

import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import com.kjj.ruixing.dao.order.Doc21bfDao;
import com.kjj.ruixing.entity.order.Doc21bf;
import com.kjj.ruixing.service.order.Doc21bfService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class Doc21bfServiceImpl extends BaseServiceImpl<Doc21bf, String> implements Doc21bfService {
    @Resource
    private Doc21bfDao doc21bfDao;

    @Override
    protected BaseDao<Doc21bf, String> getBaseDao() {
        return doc21bfDao;
    }
}