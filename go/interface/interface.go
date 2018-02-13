package main

import (
	"fmt"
)

// # 用户定义的类型的值是如何存入接口的？
// 接口值：是一个两个字长度的数据结构，见图 interface_value
// 第一个字包含一个指向内部表的指针，这个内部表叫做iTable，包含了所存储的值的类型信息，以及与这个值相关联的一组方法
// 第二个字是一个指向所存储值的指针
// 将类型信息和指针组合在一起，就将这两个值组成一种特殊关系

// # 方法集
// 方法集定义了接口的接受规则

// 图：规范里描述的方法集
// T类型的值的方法集只包含值接收者声明的方法
// T类型的指针的方法集既包含值接收者声明的方法，也包含指针接收者声明的方法。

// 图：接收者类型角度的方法集
// 如果使用指针接收者来实现一个接口，那么只有指向那个类型的指针才能实现对应的接口
// 如果使用值接收者来实现一个接口，那么那个类型的值和指针都能够实现对应的接口

// 为什么会有这种限制？
// 编译器并不是总能自动获得一个值的地址

type notifier interface {
	notify()
}

type user struct {
	name string
	email string
}

func (u *user) notify() {
	fmt.Printf("Sending user email to %s<%s>\n", u.name, u.email)
}

func sendNotification(n notifier) {
	n.notify()
}

type admin struct {
	name string
	email string
}

func (a *admin) notify() {
	fmt.Printf("Sending admin email to %s<%s>\n", a.name, a.email)
}

type duration int

func (d *duration) pertty() string {
	return fmt.Sprintf("Duration:%d", *d)
}

func main() {

	u := user{"bill", "bill@email.com"}

	// cannot use u (type user) as type notifier in argument to sendNotification:
    // user does not implement notifier (notify method has pointer receiver)
	// sendNotification(u) 方法集规则限制
	sendNotification(&u)

	// 多态性
	a := admin{"admin", "admin@email.com"}
	sendNotification(&a)

	// cannot call pointer method on duration(42)
	// cannot take the address of duration(42) 不能获取duration(42)的地址
	// duration(42).pertty()
}