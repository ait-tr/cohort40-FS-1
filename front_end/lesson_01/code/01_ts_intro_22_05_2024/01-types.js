// BOOLEAN
var isLoading;
isLoading = true;
isLoading = false;
// NUMBER
// isLoading = 42; ошибка типизации
var num = 42;
num = "hello";
// STRING
// let str: 'hello world!' | 'Goodbye!' = 'hello world!';
var str = "hello world!";
console.log(str);
// ARRAY
// let primes1: (number | string)[] = [2, 3, 5, 7, 'qwerty'];
// let primes1: number | string[] = [2, 3, 5, 7, 'qwerty'];
// let primes1: number[] | string[] | {age: number}[] = [{age: 10}, {age: 20}, {age: 30}, {age: 40}];
var primes1 = [2, 3, 5, 7];
var primes2 = [11, 13, 17, 19];
primes2.push(123); // [11, 13, 17, 19, 123]
primes2.forEach(function (e, i) { return console.log(e, i); });
// FUNCTION
var sum = function (a, b) { return a + b; };
console.log(sum(10, 5));
var obj2 = {
    age: 58,
    name: 'Tigran'
};
// если ключа нет, то js создаёт данный ключ со значением undefined
// console.log(obj2.address);
var obj = {
    name: "John",
    age: 35,
    address: {
        city: "NY",
        street: "Roosevelt",
        house: 111,
    },
};
