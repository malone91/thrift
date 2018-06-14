namespace java com.melo.thriftteam.service
include 'UserModel.thrift'
service HelloService{
    string sayHello(1:UserModel.User user);
}