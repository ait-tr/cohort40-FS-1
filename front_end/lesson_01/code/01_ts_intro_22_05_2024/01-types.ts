// BOOLEAN
let isLoading: boolean;
isLoading = true;
isLoading = false;

// NUMBER
// isLoading = 42; ошибка типизации

let num: number | string = 42;
num = 'hello';

const str = 'hello world!';
console.log(str);

// ARRAY
let primes1 = [2, 3, 5, 7];
const primes2 = [11, 13, 17, 19];

primes2.push(123); // [11, 13, 17, 19, 123]
primes2.forEach((e, i) => console.log(e));

// FUNCTION
const sum = (a: number, b: number): number => a + b;
console.log(sum(10, 5));