def get_optimal_value(capacity, weights, values):
    total_value = 0.
    x = []
    for i in range(len(weights)):
        x.append(values[i]/weights[i])

    while capacity > 0:
        m = max(x)
        if weights[x.index(m)] > capacity:
            total_value += capacity * m
            capacity -= capacity
            x.remove(m)
        else:
            capacity -= weights[x.index(m)]
            total_value += values[x.index(m)]
            x.remove(m)


    return total_value


if __name__ == "__main__":
    infile = open("input.txt", "r")
    data = list(map(int, infile.read().split()))
    n, capacity = data[0:2]
    values = data[2:(2 * n + 2):2]
    weights = data[3:(2 * n + 2):2]
    print(get_optimal_value(capacity, weights, values))
