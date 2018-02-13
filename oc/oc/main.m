//
//  main.m
//  oc
//
//  Created by 杨志文 on 2018/2/13.
//  Copyright © 2018年 杨志文. All rights reserved.
//

#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // insert code here...
        NSLog(@"Hello, World!");
        
        // 变量与表达式
        int a = 4;
        int b = 1;
        int c = a + b;
        NSLog(@"result of a+b = %d", c);
        
        // 基础数据类型 int float double char、 @“xx”、 "xx"
        // 限定类型 long、long long、short、unsigned、signed
        
        if(true) {
            NSLog(@"if(true) { } ");
        }
        
        
    }
    return 0;
}
