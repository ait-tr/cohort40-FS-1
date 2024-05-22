// BOOLEAN
var isLoading;
isLoading = true;
isLoading = false;
// NUMBER
// isLoading = 42; ошибка типизации
var num = 42;
num = 'hello';
var str = 'hello world!';
console.log(str);
// ARRAY
var primes1 = [2, 3, 5, 7];
var primes2 = [11, 13, 17, 19];
primes2.push(123); // [11, 13, 17, 19, 123]
primes2.forEach(function (e, i) { return console.log(e); });