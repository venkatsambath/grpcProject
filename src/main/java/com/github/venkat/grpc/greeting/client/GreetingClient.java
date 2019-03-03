package com.github.venkat.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;

import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I am gRPC client");

        System.out.println("Creating stub");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051).usePlaintext().build();

      //  DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(channel);
      //  DummyServiceGrpc.DummyServiceFutureStub asyncClinet = DummyServiceGrpc.newFutureStub(channel);

        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);

        Greeting greeting = Greeting.newBuilder().setFirstName("venkat").setLastName("sambath").build();

        GreetRequest request= GreetRequest.newBuilder().setGreeting(greeting).build();

        GreetResponse greetresponse = greetClient.greet(request);

        System.out.println(greetresponse.getResult());

        System.out.println("Shutting down channel");
        channel.shutdown();


    }
}
