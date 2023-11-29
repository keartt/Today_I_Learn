// npm install express 한 거 참조할게요
const express = require('express');
const app = express();

// node 에서 post data 를 받기 위해 body-parser 추가 
app.use(express.urlencoded({ extended: true }))

// 몽고디비 연결
const MongoClient = require('mongodb').MongoClient;
// ejs 관련
app.set('view engine', 'ejs');

// css 파일 들어있는 public 폴더를 쓴다
// node 에서 css 적용하기 위한 코드 
app.use('/public', express.static('public'));

// method-override  : html form 에서 put 과 delete 사용하기 위함
const methodOverride = require('method-override');
app.use(methodOverride('_method'));

const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const session = require('express-session');



MongoClient.connect('mongodb+srv://admin:1234@boilerplate.g6vcczn.mongodb.net/?retryWrites=true&w=majority', (error, client) => {
  // 연결되면 할 일
  app.listen(4000, function () {
    console.log('몽고 접속성공');
  });

  // 에러나면 할 일
  if (error) return console.log('listening on 5004')

  // 연결할 데이터베이스명
  db = client.db('chat_test');
  // 저장할 데이터, 콜백함수
})

app.get('/', function (req, res) {
  // 응답.sendFile(__dirname + '/index.html')
  res.render('index.ejs')
})

//회원가입
app.post('/register', function (요청, 응답) {
  db.collection('login').insertOne({ id: 요청.body.id, pw: 요청.body.pw }, function (에러, 결과) {
    응답.redirect('/')
  })
})

// 로그인 세션 관리 
app.use(session({secret : '비밀코드', resave : true, saveUninitialized: false}));
app.use(passport.initialize());
app.use(passport.session()); 

app.get('/login', (req, res) => {
  res.render('login.ejs')
})

app.post('/login', passport.authenticate('local', {failureRedirect : '/fail'}), 
  function(요청, 응답){
  응답.redirect('/')
});

passport.use(new LocalStrategy({
  usernameField: 'id',
  passwordField: 'pw',
  session: true,
  passReqToCallback: false,
}, function (입력한아이디, 입력한비번, done) {
  //console.log(입력한아이디, 입력한비번);
  db.collection('login').findOne({ id: 입력한아이디 }, function (에러, 결과) {
    if (에러) return done(에러)

    if (!결과) return done(null, false, { message: '존재하지않는 아이디요' })
    if (입력한비번 == 결과.pw) {
      return done(null, 결과)
    } else {
      return done(null, false, { message: '비번틀렸어요' })
    }
  })
}));

// 세션 저장코드, 로그인 성공 시 실행댐
passport.serializeUser((user, done)=>{
  done(null, user.id)
})

// 로그인한 유저의 세션아이디를 활용해서
// 정보를 DB 에서 select 해 옴
passport.deserializeUser(function (아이디, done) {
  db.collection('login').findOne({ id: 아이디 }, function (에러, 결과) {
    done(null, 결과)
  })
}); 

app.get('/mypage', 로그인했니, function (요청, 응답) { 
  console.log(요청.user); 
  console.log(요청.user._id); 
  응답.render('mypage.ejs', {사용자 : 요청.user}) 
}) 
//  마이페이지 처리할 미들웨어, 함수
function 로그인했니(요청, 응답, next) { 
  if (요청.user) { // 이게 뭔데? .. 아래 글 보셈
    next() // 통과
  } 
  else { 
    응답.send('로그인안하셨는데요?') 
  } 
} 

app.get('/write', function (req, res) {
  // res.sendFile(__dirname + '/write.html')
  res.render('write.ejs')
})


app.post('/add', function (req, res) {
  // 세션에 저장되어 있는, 로그인할 때 받은 유저의 정보 가져오기
  var id = req.user._id; //_id 는 고유하게 부여된 아이디 값

  // 게시글 개수를 셀 새로운 컬렉션에서 가져오기
  db.collection('counter').findOne({ name: '게시물개수' }, (err, result) => {
    console.log(result.totalPost);
    var artilceCount = result.totalPost;

    var 저장할거 = { _id: artilceCount + 1, writer :  id , date: req.body.date, title: req.body.title}

    // post collection 에 데이터 insert
    db.collection('post').insertOne( 저장할거, (error, result) => {
      console.log('save complete')

      // 저장 완료 후 totalPost 즉 게시글 id 번호도 1 증가시켜줘야 함
      db.collection('counter').updateOne({ name: '게시물개수' }, { $inc: { totalPost: 1 } }, (err, res) => {
        if (err) return console.log(err);
      })
    })
    // 마지막에 넣으렴
    res.redirect("/list")
  });
})

//* list 로 접속하면 실제 db 에 저장된 데이터들로 html 페이지를 보여준다 */
app.get('/list', (req, res) => {
  // 모든 data 를 배열 형식으로  뽑아옴
  db.collection('post').find().toArray((err, result) => {
    // 요청 오면 여기로  db.collection 안에서 render 넣어야 함
    res.render('list.ejs', { postList: result });
  });
})

// // 삭제
// app.delete('/delete', (req, res) => {
//   // 요청시 함께 보낸 데이터를 찾고 싶다 (요청이 게시물 번호였으므로 게시물 번호 나옴)
//   console.log(req.body);

//   // int 형으로 변환 시켜주기 
//   req.body._id = parseInt(req.body._id)

//   db.collection('post').deleteOne(req.body, (err, result) => {
//     console.log('삭제완료');
//     res.status(200).send({ message: '성공했음' }); // 응답코드 성공
//   })
// })


app.delete('/delete', function (요청, 응답) {
  요청.body._id = parseInt(요청.body._id);
  //요청.body에 담겨온 게시물번호를 가진 글을 db에서 찾아서 삭제해주세요
  db.collection('post').deleteOne({_id : 요청.body._id, 작성자 : 요청.user._id }, function (에러, 결과) {
    console.log('삭제완료');
    console.log('에러',에러)
    응답.status(200).send({ message: '성공했습니다' });
  })
});

// 상세페이지 만들기 + 게시글번호 
app.get('/detail/:id', (req, res) => {
  db.collection('post').findOne({ _id: parseInt(req.params.id) }, (err, result) => {
    console.log(result)
    res.render('detail.ejs', { data: result })
  })
})

// edit
app.get('/edit/:id', (req, res) => {
  db.collection('post').findOne({ _id: parseInt(req.params.id) }, (err, result) => {
    res.render('edit.ejs', { data: result })
  })
})

// edit put 요청
app.put('/edit', (req, res) => {
  db.collection('post').updateOne({ _id: parseInt(req.body.id) },
    { $set: { title: req.body.title, date: req.body.date } }, () => {
      console.log('수정성공')
      res.redirect('/list')
    })
})

var ObjectId = require('mongodb').ObjectID;

app.post('/chatroom', function(요청, 응답){
  console.log('요청.body.당한사람id = ' + 요청.body.당한사람id)
  var 저장할거 = {
    title : '무슨무슨채팅방',
    member : [ObjectId(요청.body.당한사람id), 요청.user._id],
    date : new Date()
  }

  db.collection('chatroom').insertOne(저장할거).then(function(결과){
    응답.send('저장완료')
  });
});

app.get('/chat', 로그인했니, function(요청, 응답){ 

  db.collection('chatroom').find({ member : 요청.user._id }).toArray().then((결과)=>{
    console.log(결과);
    응답.render('chat.ejs', {data : 결과})
  })

}); 
