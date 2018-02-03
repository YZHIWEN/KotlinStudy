package main

import "fmt"

// # var
// 以小写字母开头的标识符是不公开的，不能被其他包中代码直接访问
// 但是其他包可以间接访问不公开标识符
var temp = make(map[string]string)

func main() {

	// 声明，指定类型和大小，一旦声明都不能变
	// 只有这种声明可以不在函数内
	var array [5]int
	// 使用数组字面量声明数组
	array_ := [5]int{1,2,3,4,5}
	// 使用...自动计算声明数组长度
	array__ := [...]int{2,3,4,5,6}
	// 指定特定元素
	array___ := [5]int{1:10, 3:30}

	fmt.Println(array)
	fmt.Println(array_)
	fmt.Println(array__)
	fmt.Println(array___)


	arr := [5]*int{0: new(int), 1: new(int)}
	*arr[0] = 10
	*arr[1] = 20
	// *arr[2] = 30 // error
	var num = 40
	arr[3] = &num
	fmt.Println(arr)

	// 数组赋值
	// - 当数组长度与类型一样才可以，则为复制
	var str1 [5]string
	str2 := [5]string{"r", "b", "g", "y", "p"}
	str1 = str2
	fmt.Println(str1)
	str1[0] = "xxxxx"
	fmt.Println(str1)
	fmt.Println(str2)
	// - 当类型一样，长度不一样则会编译出错
	// - 当时指针数组则也要长度和类型一致，但赋值后不是复制，两个数组指向地址相同
	var str3 [3]*string
	var str4 = [3]*string{new(string), new(string), new(string)}
	str3 = str4
	fmt.Println(str3)
	fmt.Println(str4)

	// # 多维
	var aa [2][2]int
	aa[0][0] = 1

	// 在函数间传递数组
	// 根据内存和性能来看，在函数间传递数组是一个开销很大的操作
	// 如果是传递变量，总是以值的方式传递
	// 如果这个变量是数组，都会进行复制到栈再传递给函数
	// 所以建议使用指针在函数间传递大数组
	// 但是传递指针，如果改变指针指向的值，会改变共享内存，所以可以使用切片更好的处理这个共享问题
}

// 使用指针在函数间传递大数组
func foo(array *[1e6]int)  {
	
}