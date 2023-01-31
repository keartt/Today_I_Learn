class Calculator {
  constructor(output) {
      this.output = output
      this.displayContent = ''
      this.clear()
  }
//appendNumber 메서드(작업) 추가.
  appendNumber(number) {
      this.displayContent += number
  }
  appendOperator(operator) {
      this.displayContent += operator
  }
//updateDisplay 메서드(작업)추가.
//this.displayElemnet의 값(value)에 this.displayContent를 담는다
  updateDisplay() {
      this.output.value = this.displayContent
  }

  clear() {
      this.displayContent = ''
      this.output.value = 0
  }
  compute() {
      this.displayContent = eval(this.displayContent
          //"\u00D7" 는 ×, "\u00F7"는 ÷를 의미한다.
          .replace('\u00D7', '*')
          .replace('\u00F7', '/')
      )
  }
}



const buttons = document.querySelectorAll('button')
const output = document.querySelector('input')

const calculator = new Calculator(output)

buttons.forEach(button => {
  button.addEventListener('click', () => {
      switch (button.dataset.type) {
          case 'operator':
              calculator.appendOperator(button.innerText)
              calculator.updateDisplay()
              break
          case 'ac':
              calculator.clear()
              break
          case 'equals':
              calculator.compute()
              calculator.updateDisplay()
              break
          default:
              calculator.appendNumber(button.innerText)
              calculator.updateDisplay()
              break
      }
  })
})