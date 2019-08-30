package com.pm.grpc;

import com.pm.proto.MyRequest;
import com.pm.proto.MyResponse;
import com.pm.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/21 15:59
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端信息：" + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }
}
