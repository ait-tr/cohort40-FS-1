// BOOLEAN
let isLoading: boolean;
isLoading = true;
isLoading = false;

// NUMBER
// isLoading = 42; ошибка типизации

let num: number | string = 42;
num = "hello";

// STRING
// let str: 'hello world!' | 'Goodbye!' = 'hello world!';
const str = "hello world!";
console.log(str);

// ARRAY
// let primes1: (number | string)[] = [2, 3, 5, 7, 'qwerty'];
// let primes1: number | string[] = [2, 3, 5, 7, 'qwerty'];
// let primes1: number[] | string[] | {age: number}[] = [{age: 10}, {age: 20}, {age: 30}, {age: 40}];
let primes1: number[] = [2, 3, 5, 7];
const primes2: number[] = [11, 13, 17, 19];

primes2.push(123); // [11, 13, 17, 19, 123]
primes2.forEach((e: number, i: number): void => console.log(e, i));

// FUNCTION
const sum = (a: number, b: number): number => a + b;
console.log(sum(10, 5));

// OBJECTS & INTERFACES
interface IObj {
  name: string;
  age: number;
  address?: IAddress;
}

interface IAddress {
  city: string;
  street: string;
  house: number;
}

const obj2: IObj = {
  age: 58,
  name: 'Tigran'
};

// если ключа нет, то js создаёт данный ключ со значением undefined
// console.log(obj2.address);

const obj: IObj = {
  name: "John",
  age: 35,
  address: {
    city: "NY",
    street: "Roosevelt",
    house: 111,
  },
};
