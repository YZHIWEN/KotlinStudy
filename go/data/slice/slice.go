package main

import "fmt"

// # 切片
// 切片是围绕动态数组概念构建的，可以按需自动增长和缩小
// 切片的动态增长是通过内置函数append来实现的，这个函数可以快速高效地增长切片，还可以通过切片再次切片来缩小一个切片的大小
// 因为切片的底层内存也是在连续块中分配的，所以切片还能通过索引、迭代以及为垃圾回收优化带来好处

// # 内部
// 切片是一个对底层数组提供抽象和操作方法的对象，如图
// 切片有三个字段，地址、长度、容量
// 这三个字段分别表示指向底层数组的指针、切片访问的元素的个数和切片允许增长到的元素个数



func main() {

	// # 创建 & 初始化
	// 基于make
	s1 := make([]int, 5) // 同时指定长度和容量
	s2 := make([]int, 3, 5)// 分别指定长度和容量

	// 如果基于一个切片创建新的切片，新的切片会和原有切片共享底层数组，也能通过后期操作来访问多余容量的元素

	// 基于切片字面量，创建的长度和容量都一致
	s3 := []string{"r", "b", "g", "y"}
	s4 := []int{10, 20, 30}
	s5 := []int{90:90} // 基于索引

	// note:在[]指定值，则创建的是数组，只在不指定值的时候创建切片
	array := [3]int{1, 2, 3}
	slice := []int{1, 2, 4}

	// 地址指向nil的切片
	nilSlice := []int{}
	nilSlice2 := make([]int, 0)

	// # 使用
	// 底层原理如图slices.png
	// 对于底层数组容量为k的切片slice[i::j]来说，
	// 长度为j-i、容量为k-i
	// 切片只能访问到其长度内的元素
	newSlice := slice[1:2]

	// # 切片增长
	// 函数append总是会增加新切片的长度，而容量是否改变取决于被操作切片的可用容量
	// 函数 append 会智能地处理底层数组的容量增长。在切片的容量小于 1000 个元素时，总是 会成倍地增加容量。一旦元素个数超过 1000，容量的增长因子会设为 1.25，也就是会每次增加 25% 的容量。随着语言的演化，这种增长算法可能会有所改变。

	// # 切片的三个索引
	// slice[i:j:k]，长度和容量计算公式没变
	// 如果在创建切片时设置切片的容量和长度一样，就可以强制让新切片的第一个 append 操作 创建新的底层数组，与原有的底层数组分离。新切片与原有的底层数组分离后，可以安全地进行 后续修改
	source := []string{"Apple", "Orange", "Plum", "Banana", "Grape"}
	newSource := append(source, "Kiwi")
	fmt.Println(newSource)

	// 将两个切片追加在一起
	s6 := append(s1, s2...)

	// 迭代切片
	// 使用range会返回两个值，第一个为索引位置，第二个为该位置对呀元素的一份副本（非引用）
	// 可以使用空白标识符来忽略range返回的两个值
	for index, value := range s6 {
		fmt.Printf("Index %d Value %d\n",index, value)
	}

	for index := 0; index < len(s6); index++ {
		//..
	}

	fmt.Println(s1)
	fmt.Println(s2)
	fmt.Println(s3)
	fmt.Println(s4)
	fmt.Println(s5)

	fmt.Println(array)
	fmt.Println(slice)

	fmt.Println(nilSlice)
	fmt.Println(nilSlice2)

	fmt.Println(newSlice)

	fmt.Println(s6)

	// # 多维切片
	// 结构见图
	slices := [][]int{{10}, {100, 200}}

	fmt.Println(slices)

	// # 在函数间传递切片
	// 由于切片只是一个包括简单的对象，在函数间复制和传递切片的成本很低
}

func to(slice []int) []int {
	return slice
}