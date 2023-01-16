var { default:Git ,Branch, Checkout } = require("nodegit");
const { assignRepoName, refRepoName, masterRepoName } = require('./package').swRepoManager;
const fs = require('fs-extra');

// 브랜치의 특정 버전의 내용을 폴더로 복사하는 함수
const copyAll = function (branch){
    return new Promise(function (resolve, reject) {
        Git.Clone(branch.url, branch.name)
        .then(function (repo) {
            return repo.getHeadCommit();
        })  
      }).catch(function (err) {
        console.log(err);
        reject(err);
      });
  // fs.readdirSync(`./${masterRepoName}/`).forEach(file => {
  //   fs.copySync(`./${masterRepoName}/${file}`, `./${assignRepoName}/${file}`);
  //   fs.copySync(`./${masterRepoName}/${file}`, `./${refRepoName}/${file}`);
  // });
}
// Find current repo's latest vertion tag
const latestVertionTag = precess.env.SW_REPO_VERSION | Git.Tag.list('./').pop();
const authorSignature = Signature.now(precess.env.SW_REPO_AUTHORNAME | "seungwoo.hong", precess.env.SW_REPO_AUTHOREMAIL | "seungwoo.hong@codestates.com");
// assignRepoName에 최신 버전의 내용만 넣는다.
Git.Repository.open(`./${assignRepoName}`)
  // Open the master branch.
  .then(function(repo) {
    // TODO : 1. git branch -D master
    Branch.delete('master').then(function(result) {
        // TODO : 2. file copy all & commit it.


        // TODO : 3. git checkout origin/master -b master
        const tree = repo.getTree(latestVertionTag);
        const parent_count = tree.entrycount();
        const parents = [];
        const target = Commit.create(repo, "HEAD", authorSignature, authorSignature, "UTF-8", "message", tree, parent_count, parents)
          .then(function(oid) {
            // Use oid
            Branch.create(repo, 'master', target, 0).then(function(reference) {
              // Use reference
              // TODO : 4. git set tag latestVertionTag

            });
            Checkout.head(repo).then(function() {
                // checkout complete
            });
                
          });
    });

    return repo.getMasterCommit();
  });