### Ranges
    

### How it works
- 主要实现原理可以看kotlin的ranges包

- Ranges implement a common interface in the library: ClosedRange<T>.

- ClosedRange<T> denotes a closed interval in the mathematical sense, defined for comparable types. It has two endpoints: start and endInclusive, which are included in the range. The main operation is contains, usually used in the form of in/!in operators.


- Integral type progressions (IntProgression, LongProgression, CharProgression) denote an arithmetic progression. Progressions are defined by the first element, the last element and a non-zero step. The first element is first, subsequent elements are the previous element plus step. The last element is always hit by iteration unless the progression is empty.

- A progression is a subtype of Iterable<N>, where N is Int, Long or Char respectively, so it can be used in for-loops and functions like map, filter, etc. Iteration over Progression is equivalent to an indexed for-loop in Java/JavaScript:
```
for (int i = first; i != last; i += step) {
  // ...
}
```

- For integral types, the .. operator creates an object which implements both ClosedRange<T> and *Progression. For example, IntRange implements ClosedRange<Int> and extends IntProgression, thus all operations defined for IntProgression are available for IntRange as well. The result of the downTo() and step() functions is always a *Progression.

- Progressions are constructed with the fromClosedRange function defined in their companion objects:
```
IntProgression.fromClosedRange(start, end, step)
```
- The last element of the progression is calculated to find maximum value not greater than the end value for positive step or minimum value not less than the end value for negative step such that (last - first) % step == 0.

