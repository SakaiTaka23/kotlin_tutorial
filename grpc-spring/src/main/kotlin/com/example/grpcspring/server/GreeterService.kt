package com.example.grpcspring.server

import example.greeter.GreeterGrpcKt
import example.greeter.HelloRequest
import example.greeter.HelloResponse
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class GreeterService: GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun hello(request: HelloRequest): HelloResponse {
        return HelloResponse.newBuilder().setText("Hello ${request.name}").build()
    }
}
