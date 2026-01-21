def solution(rows, columns, queries):
    graph = []

    idx = 1
    for i in range(rows):
        line = []
        for k in range(columns):
            line.append(idx)
            idx += 1
        graph.append(line)
        
    # print(graph)

    answer = []
    for i in queries:
        left_x, left_y, right_x, right_y = i[0] - 1, i[1] - 1, i[2] - 1, i[3] - 1

        answer.append(rotate(graph, left_x, left_y, right_x, right_y))

        # print(graph)
        # print("---------------------")

    return answer


def rotate(graph, left_x, left_y, right_x, right_y):
    line = []

    for y in range(left_y, right_y):
        line.append(graph[left_x][y])

    for x in range(left_x, right_x):
        line.append(graph[x][right_y])

    for y in range(right_y, left_y, -1):
        line.append(graph[right_x][y])

    for x in range(right_x, left_x, -1):
        line.append(graph[x][left_y])

    line.insert(0, line[-1])
    del line[-1]

    idx = 0

    for y in range(left_y, right_y):
        graph[left_x][y] = line[idx]
        idx += 1

    for x in range(left_x, right_x):
        graph[x][right_y] = line[idx]
        idx += 1

    for y in range(right_y, left_y, -1):
        graph[right_x][y] = line[idx]
        idx += 1

    for x in range(right_x, left_x, -1):
        graph[x][left_y] = line[idx]
        idx += 1

    return min(line)


# print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]), [8, 10, 25])
# print(
#     solution(3, 3, [[1, 1, 2, 2], [1, 2, 2, 3], [2, 1, 3, 2], [2, 2, 3, 3]]),
#     [1, 1, 5, 3],
# )
# print(
#     solution(6, 8, [[1, 1, 2, 2]]),
#     [1, 1, 5, 3],
# )

# print(solution(100,97,[[1,1,100,97]]), [1])

    