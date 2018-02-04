// # package
// package : 给包命名的惯例是使用保所在目录的名字，这让用户在导入包可以清晰地知道包名；同时应该使用简洁、清晰、全小写的名字，有利于频繁输入包名。
// main package : 命名为main的包，编译程序会试图把这种名字的包编译为二进制可执行文件，并且同时需要main()函数
package main

// # import
// 标准库中 的包会在安装 Go 的位置找到。Go 开发者创建的包会在 GOPATH 环境变量指定的目录里查找。
// 查找顺序是 go安装目录 -> GOPATH环境变量顺序 直到查找结束
// 远程导入：如果路径包含 URL，可以使用 Go 工具链从 DVCS 获取包，并把包的源代码保存在 GOPATH 指向的路径里与 URL 匹配的目录里。这个获取过程 使用 go get 命令完成
// 命名导入：解决导入的多个包具有相同的名字
// 导入没有使用的包，会编译失败
// 空白标识符 _ ,这个标识符用来抛弃不想继续使用的值，如函数返回值，导入包
import "fmt"
import (
	// myfmt "xx/fmt"
	_ "strings"
)

// # init func
// 每个包可以包含多个init函数，这些函数会在程序执行开始的时候被调用，在main函数前执行
// init函数用在设置包、初始化变量或者其他要在程序运行前优先完成的引导工作
// todo 具体使用场景
func init() {
	fmt.Println("init func")
}

// # main func
// main 函数保存在名为main的包里，否则则不会生成可执行文件
func main() {
	fmt.Println("main func")
}

// # if for func