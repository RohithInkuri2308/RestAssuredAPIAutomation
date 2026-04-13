const jsonServer = require('json-server')
const auth = require('json-server-auth')

const app = jsonServer.create()
const router = jsonServer.router('db.json')
const middlewares = jsonServer.defaults()

// IMPORTANT: bind the router to the app
app.db = router.db

app.use(middlewares)
app.use(auth)
app.use(router)

app.listen(2308, () => {
  console.log('JSON Server with Auth is running on http://localhost:2308')
})