enum Node<T: Equatable> {
    case tail
    indirect case node(value: T, next: Node)

    var isTail: Bool {
        return self == .tail
    }

    var value: T? {
        switch self {
        case .tail: return nil
        case .node(let val, _): return val
        }
    }

    var next: Node {
        switch self {
        case .tail: return self
        case .node(_, let nxt): return nxt
        }
    }

    static func ==(lhs: Node, rhs: Node) -> Bool {
        switch (lhs, rhs) {
        case (.tail, .tail):
            return true
        case (.node(let lhsNode), .node(let rhsNode)):
            return lhsNode.value == rhsNode.value
              && lhsNode.next == rhsNode.next
        default:
            return false
        }
    }
}
