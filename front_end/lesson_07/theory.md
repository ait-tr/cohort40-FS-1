**Этапы жизненного цикла компонента и хук useEffect()** 

В React каждый компонент проходит определенные этапы жизненного цикла. Эти этапы включают:

1. **Инициализация (Mounting)**: Создание и вставка компонента в DOM.
2. **Обновление (Updating)**: Изменение состояния или пропсов компонента.
3. **Удаление (Unmounting)**: Удаление компонента из DOM.


**Принцип работы useEffect в контексте жизненного цикла компонента**

**Монтирование (Mounting)**:

    - Когда компонент впервые монтируется в DOM, useEffect выполняет свой эффект. Это аналогично componentDidMount в классовом компоненте.


**Обновление (Updating)**:

    - Когда компонент обновляется (например, из-за изменения состояния или пропсов), useEffect снова выполняет свой эффект, если значения в массиве зависимостей изменились. Это аналогично componentDidUpdate.
    - Перед выполнением нового эффекта, если предыдущий эффект возвращал функцию очистки, эта функция будет вызвана для очистки предыдущего эффекта.

**Размонтирование (Unmounting)**:

    - Когда компонент размонтируется, функция очистки, возвращенная useEffect, будет вызвана, чтобы удалить побочные эффекты.



**Несколько примеров**

```jsx
import React, { useEffect } from 'react';

function Component() {
  useEffect(() => {
    console.log('Компонент смонтирован');

    return () => {
      console.log('Компонент размонтирован');
    };
  }, []);

  return <div>Пример компонента</div>;
}
```

  В этом примере:

1. Сообщение "Компонент смонтирован" будет выведено при монтировании компонента.
2. Сообщение "Компонент размонтирован" будет выведено при размонтировании компонента.


```jsx
import React, { useState, useEffect } from 'react';

function ComponentWithDependencies() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log(`Значение count изменилось: ${count}`);

    return () => {
      console.log(`Очистка эффекта для count: ${count}`);
    };
  }, [count]);

  return (
    <div>
      <p>Счетчик: {count}</p>
      <button onClick={() => setCount(count + 1)}>Увеличить</button>
    </div>
  );
}
```

  В этом примере:

1. Эффект выполняется при первом рендере и каждый раз, когда count изменяется.
2. Функция очистки вызывается перед каждым новым выполнением эффекта, когда count изменяется.