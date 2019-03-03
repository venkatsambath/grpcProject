package com.github.venkat.grpc.greeting.server;

import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {

        //extract the field we need
        Greeting greeting=request.getGreeting();

        String fname=greeting.getFirstName();

        String result = "Hello " +fname;

        //create response

        GreetResponse response = GreetResponse.newBuilder().setResult(result).build();

        //send response
        responseObserver.onNext(response);
        //super.greet(request, responseObserver);

        responseObserver.onCompleted();
    }
}
