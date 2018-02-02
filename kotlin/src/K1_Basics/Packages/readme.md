
### Package
- 包名不需要与目录一样

- 在包下的Class、fun，都被声明为`package.xxx`
- 如果没有package，则为默认包，被声明为`xxx`

###import
- 可以import Class、fun、enum等声明
- 不像Java使用import static引入某些静态方法、静态常量
- 使用as解决import冲突

```
import foo.Bar // Bar is accessible
import bar.Bar as bBar // bBar stands for 'bar.Bar'
```
- import 语法
```
import (used by preamble)
  : "import" SimpleName{"."} ("." "*" | "as" SimpleName)? SEMI?
  ;
```