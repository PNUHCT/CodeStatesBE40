const yesno = require('yesno');   // commonjs approach
const onExit = require('signal-exit')
let isSignal = true;
onExit(function (code, signal) {
//   console.log('signal!', code, isSignal)
//   console.log('\n-------STOP-------');
  process.exit(!isSignal && code == 0? 0 : 1); // cntl-c 를 해도 exit(1)로 파이프 라인에서 인식되도록
});

(async () => {
    console.log('\n-----------------');
    const ok = await yesno({
        question: '? y/n',
        yesValues: [ 'y', 'yes', 'Y', 'Yes', 'YES' , 'ㅛ' ],
        noValues: [ 'n', 'no', 'N', 'No', 'NO', 'ㅜ' ],
    });
    if(ok) {
        // console.log('\n-------NEXT-------');
        isSignal = false;
        process.exit(0);
    } else {
        // console.log('\n-------STOP-------');
        isSignal = false;
        process.exit(1); // Uncaught Fatal Exception https://nodejs.org/api/process.html#process_exit_codes
    }
})();
