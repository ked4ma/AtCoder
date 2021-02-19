const {JSDOM}= require('jsdom')
const request = require('request')
const rp = require('request-promise')
const fs = require('fs')

const BASE_URL = 'https://atcoder.jp'

async function parseContest(contest, question) {
  return await rp(`${BASE_URL}/contests/${contest}/tasks?lang=ja`).catch(err => {
    console.log(err)
    console.log(`[Err] Contest(${contest}) page is not found.`)
    process.exit(1)
  }).then(body => {
    const doc = (new JSDOM(body)).window.document
    return [...doc.querySelectorAll('div.panel table.table tbody tr td:first-child a')].map(elem => {
      return [elem.textContent, `${BASE_URL}${elem.href}`]
    }).reduce((l, [k, v]) => Object.assign(l, {[k]: v}), {})
  })
}

function parse(body, outputFile, ansOutputFile) {
  const doc = (new JSDOM(body)).window.document
//  const text = [...doc.querySelectorAll('.lang-ja .part > section:nth-child(1) > pre:nth-of-type(1)')].filter((t, i) => {
//    return i % 2 == 1
//  }).map((elem) => {
//    return elem.textContent
//  }).join('---\n')
  const re = new RegExp('(入|出)力例 .*')
  const data = [...doc.querySelectorAll('.lang-ja .part > section:nth-child(1)')].filter((t, i) => {
    return t.querySelectorAll('h3')[0].textContent.match(re)
  }).map((elem) => {
    return elem.querySelectorAll('pre')[0].textContent
  })

  const text = data.filter((t, i) => {
    return i % 2 == 0
  }).join('---\n')
  fs.writeFile(outputFile, text, err => {
    if (err) {
      console.log(err)
    }
  })

  const ansText = data.filter((t, i) => {
    return i % 2 == 1
  }).join('---\n')
  fs.writeFile(ansOutputFile, ansText, err => {
    if (err) {
      console.log(err)
    }
  })
}

;(async () => {
  if (process.argv.length < 6) {
    console.log('[Err] contest and question name is needed')
    process.exit(1)
  }
  const contest = process.argv[2]
  const question = process.argv[3]
  const outputFile = process.argv[4]
  const ansOutputFile = process.argv[5]

  const links = await parseContest(contest, question)
  request.get(links[question], (err, res, body) => {
    if (err) {
      console.log(`[Err] question page(${question}) of contest(${contest}) is not found.`)
      process.exit(1)
    }
    parse(body, outputFile, ansOutputFile)
  })
})()
