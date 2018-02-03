package main

import (
	"fmt"
)

// # todo 原理细节

func main() {
	// key：可以是内置类型或结构类型，只要这个值可以使用==运算符作比较
	dict := make(map[string]int)
	dict2 := map[string]string{"red": "#da1337", "Orange": "#e95a22"}
	// dict3 := map[[]string]int{} // key type error, key为切片
	dict4 := map[int][]string{}

	// nil映射，不能用于存储键值对，否则会发生语言运行时错误
	// var colors map[string]string // nil映射
	// colors["r"] = "x" // error

	// map取值 & key判断
	value, exists := dict2["blue"]
	if exists {
		fmt.Println(value)
	} else {
		fmt.Println("no exists!")
	}

	// 如果不存在则返回对应类型的零值
	v := dict2["red"]
	if v != "" {
		fmt.Println(v)
	}

	for key, value := range dict2 {
		fmt.Printf("key %s - value %s\n", key, value)
	}

	fmt.Println(dict)
	fmt.Println(dict2)
	fmt.Println(dict2["red"])
	fmt.Println(dict4)

	// # 在函数间传递并不会制造出该映射的一个副本
}