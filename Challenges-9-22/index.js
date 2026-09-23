let list = document.querySelector('#repoList');

async function getRepos() {
    
    let response = await fetch('https://api.github.com/users/canlyk/repos');
    let parsedResponse = await response.json();

    parsedResponse.forEach(repo => {
        let li = document.createElement('li');
        let a = document.createElement('a');
        a.href = repo.html_url;
        a.textContent = repo.name;
        li.appendChild(a);
        list.appendChild(li);
    });
}

getRepos();