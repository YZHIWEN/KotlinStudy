package main

import (
	"fmt"
)
// 声明结构类型
type user struct {
	name string
	email string
	ext int
	privileged bool
}

type admin struct {
	person user
	level string
}

// 声明新类型
// int64类型叫作Duration的基础类型
// 不过Go不认为Duration和int64是同一种类型

// 编译器只允许为命名的用户定义的类型声明方法
type Duration int64

func main() {

	// 声明，默认值
	var bill user
	// 声明，指定值，对顺序没要求
	lisa := user {
		name:"lisa", 
		email:"lisa@email.com",
		ext:123,
	}
	// 指定值声明，对顺序有要求，并且需要制定全部
	mark := user{"mark", "mark@email.com", 123, false}

	fred := admin{
		person: user{
			name:"fred",
			email:"fred@email.com",
		},
		level:"super",
	}

	// error 不同类型
	// var dur Duration
	// dur = int64(100)

	fmt.Println(bill)
	fmt.Println(lisa)
	fmt.Println(mark)
	fmt.Println(fred)
}