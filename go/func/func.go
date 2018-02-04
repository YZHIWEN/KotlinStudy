package main

import "fmt"

type user struct {
	name string
	email string
}

// Go有两种类型接收者，值接收者 和 指针接收者
// 如果是值接收者声明方法，调用时会使用这个值的一个副本来执行
func (u user) notify() {
	fmt.Printf("Sending User Email To %s<%s>\n", u.name, u.email)
}

func (u *user) changeEmail(email string) {
	u.email = email
}

func main() {
	bill := user{"Bill", "bill@email.com"}
	bill.notify()

	lisa := &user{"Lisa", "lisa@email.com"}
	lisa.notify()

	bill.changeEmail("new_bill@email.com")// 背后(&bill).changeEmail("xxx")
	bill.notify()

	lisa.changeEmail("new_lisa@email.com")
	lisa.notify()
}