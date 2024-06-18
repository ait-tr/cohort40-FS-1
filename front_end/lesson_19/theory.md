**Как выложить страницу на github pages**

1. Создайте папку на компьютере с проектом и кодом (index.html, styles.css и т.д.)
2. Зайдите на github в браузере и создайте пустой репозиторий. (для этого: ваш профиль -> repositories -> зеленая кнопка new -> задаем имя репозитория Repository name -> зеленая кнопка Create repository )
3. Инициировать локальный репозиторий. Для этого, ввести в VSCode команду git init. Внутри папки вашего проекта появится скрытая папочка .git
4. Далее копируем команды в браузере из предложенных:
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/<username>/<repo-name>.git
git push -u origin main

**ВАЖНО** (Не забудьте заменить <username> и <repo-name> на ваше актуальное имя пользователя и имя репозитория. - можете взять эту команду из предложенных при создании репозитория)

Теперь осталось только опубликовать на gitPages Заходим в репозиторий в бразуере -> settings -> в левом сайдбаре Pages -> заменяем branch с none на main -> нажимаем save -> ссылка появится через некоторое время (можно обовлять страничку)

**Как выложить vite project на github pages**

1. В package.json вашего проекта перед строчкой name добавьте строку
``` json
  "homepage": "./", 
```

2. Установите пакет gh-pages при помощи команды ```sh npm install gh-pages -D``

3. Добавьте свойства "predeploy" и "deploy" в скрипт в "scripts" в package.json
``` json
 "scripts": {
    //...
   "predeploy": "npm run build",
   "deploy": "gh-pages -d dist"
 },
```

4. Создайте пустой репозиторий на GitHub. Вы можете назвать его так же как ваше приложение.

5. В файле vite.config.ts добавьте строчку base: '/имя-репозитория-гитхаб/'

**Пример** того, как выглядит файл после добавления.

```tsx
import { defineConfig } from 'vitest/config';
import react from '@vitejs/plugin-react';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  base: '/vite-deploy/'
});
```

6. Если в вашем проекте используется роутер, замените BrowserRouter на HashRouter:

```tsx
import { HashRouter } from 'react-router-dom';

const root = ReactDOM.createRoot(
 document.getElementById('root') as HTMLElement
);
root.render(
 <React.StrictMode>
   <HashRouter>
     <App />
   </HashRouter>
 </React.StrictMode>
);
```

7. Добавьте "remote" к вашему локальному GitHub репозиторию. Для этого запустите в терминале команды:

```bash
git init

git remote add origin https://github.com/<username>/<repo-name>.git 
```

**ВАЖНО** (Не забудьте заменить <username> и <repo-name> на ваше актуальное имя пользователя и имя репозитория. - можете взять эту команду из предложенных при создании репозитория)

8. Запустите deploy React app в GitHub Для это запустите команду: npm run deploy

Это приведет к запуску скриптов predeploy и deploy, определенных в package.json.


P.S. 
1. Под капотом сценарий предварительного развертывания(predeploy) создаст дистрибутив версию приложения React и сохранит ее в папке с именем dist. Затем сценарий развертывания запушит содержимое этой папки в новую в ветку gh-pages вашего репозитория GitHub, создав эту ветку, если она еще не существует.

2. По умолчанию новый коммит в ветке gh-pages будет иметь сообщение коммита `Updates`. Вы можете указать собственное сообщение коммита: 

```bash
npm run deploy -- -m "Deploy React app to GitHub Pages"
```

Настройка GitHub Pages (этот шаг может сделаться автоматически, тогда просто проверьте, что все так) В вашем браузере перейдите в настройки GitHub Pages "Settings" --> "Code and automation" --> "Pages" --> "Build and deployment"

Выберите следующие значения:

**Source**: Deploy from a branch
**Branch**: gh-pages
**Folder**: / (root)

Нажмите "Save".