struct LinkedList<T: Equatable>: ExpressibleByArrayLiteral {
    private var head: Node<T>

    init() {
        head = .tail
    }

    init(arrayLiteral elements: T...) {
        self.init()
        elements.reversed().forEach { v in
            add(v)
        }
    }

    var count: Int {
        var counter = 0
        var node = head
        while !node.isTail {
            counter += 1
            node = node.next
        }
        return counter
    }

    mutating func add(_ value: T) {
        let oldHead = head
        head = .node(value: value, next: oldHead)
    }

    subscript(_ idx: Int) -> T? {
        guard idx >= 0 else { return nil }

        if idx == 0 { return head.value }

        var searchedNode = head
        for _ in 1...idx {
            searchedNode = searchedNode.next
        }

        if searchedNode.isTail {
            return nil
        } else {
            return searchedNode.value
        }
    }
}
