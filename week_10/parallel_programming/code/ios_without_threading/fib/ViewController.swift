import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var resultLabel: UILabel!
    @IBOutlet weak var inputField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        resultLabel.text = nil
    }
    
    @IBAction func calculateResult(_ sender: UIButton) {
        guard let text = inputField.text, let input = Int(text) else {
            resultLabel.text = "Sorry, that doesn't look like a number"
            return
        }
        let result = fib(input)
        resultLabel.text = "Fibonacci number \(input) is \(result)"
    }
    
    private func fib(_ n: Int) -> Int {
        switch n {
        case lessThan(2): return n
        default: return fib(n - 1) + fib(n - 2)
        }
    }
    
    private func lessThan<T: Comparable>(_ a: T) -> (T) -> Bool {
        return { (b: T) in b < a }
    }
    
}

fileprivate func ~=<T: Comparable>(pattern: (T) -> Bool, value: T) -> Bool {
    return pattern(value)
}
