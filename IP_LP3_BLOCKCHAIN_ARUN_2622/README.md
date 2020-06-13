# blockchain-vote
- Check if npm is installed using this command on the Ubuntu terminal `npm -v`
- You will get a version number starting with 5, you are good to go the next step.
- Clone this git repo 
- `cd` into the repo

- Run this command to install web3 and ganache-cli `sudo npm install ganache-cli web3@0.20.1`
- Install the solidity compiler `npm install solc`
*Note:* `testrpc` is deprecated and now we have `ganache-cli`
- Start the test blockchain network like this: `node_modules/.bin/testrpc`. If all is well, this returns a list of 10 `eth` accounts and starts the blockchain network.

## Troubleshooting steps - dev env setup
If you get an error message `npm update check failed`, run this on terminal - 
  - `sudo chown -R $USER:$(id -gn $USER) /home/<username>/.config`
  - `sudo npm install -g npm`

##  Start a test blockchain network

`$node_modules/.bin/ganache-cli`

##  Compile Smart Contract
``
> Web3 = require('web3')

> web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:8545"));

> web3.eth.accounts
> code = fs.readFileSync('Voting.sol').toString()
>solc = require('solc')
> compiledCode = solc.compile(code)
```





## Get an instance of VotingContract
```
> abiDefinition = JSON.parse(compiledCode.contracts[':Voting'].interface)
> VotingContract = web3.eth.contract(abiDefinition)
> byteCode = compiledCode.contracts[':Voting'].bytecode
```
## Deploy Smart contract
```
> deployedContract = VotingContract.new(['MODI','RAHUL','MAMTA DIDI'],{data: byteCode, from: web3.eth.accounts[0], gas: 4700000})
> deployedContract.address
> contractInstance = VotingContract.at(deployedContract.address)

```




## Interacting with contract on console
```
>contractInstance.totalVotesFor.call('MODI')
{ [String: '0'] s: 1, e: 0, c: [ 0 ] }

>contractInstance.voteForCandidate('MODI', {from: web3.eth.accounts[0]})

>contractInstance.totalVotesFor.call('MODI').toLocaleString()
'3'
```
Save the contractInstance.address for next exercise.


## Building a Simple web page
- Clone this repo
- Open index.js and change the contractInstance.address to your own address
- Open index.html on any browser
- Increment votes and play around.

