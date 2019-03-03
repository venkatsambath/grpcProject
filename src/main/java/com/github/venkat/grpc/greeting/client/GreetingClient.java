package com.github.venkat.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I am gRPC client");

        System.out.println("Creating stub");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051).build();

        DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(channel);
      //  DummyServiceGrpc.DummyServiceFutureStub asyncClinet = DummyServiceGrpc.newFutureStub(channel);

        System.out.println("Shutting down channel");
        channel.shutdown();


    }
}
