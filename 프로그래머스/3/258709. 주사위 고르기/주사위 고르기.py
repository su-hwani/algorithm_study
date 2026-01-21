from bisect import bisect_left
from itertools import combinations, product


def solution(dice):
    idx = [i for i in range(len(dice))]

    answer = []
    for my_dices in combinations(idx, len(dice) // 2):
        your_dices = []

        for x in idx:
            if x not in my_dices:
                your_dices.append(x)

        my_dices_value = [dice[i] for i in my_dices]
        your_dices_value = [dice[i] for i in your_dices]

        my_dices_case = get_case(my_dices_value)
        your_dices_case = get_case(your_dices_value)

        your_dices_case.sort()

        ans = 0
        for i in my_dices_case:
            r = bisect_left(your_dices_case, i)
            ans += r

        answer.append((ans, my_dices))

    answer = max(answer)
    new_answer = list(answer[1])
    for i in range(len(new_answer)):
        new_answer[i] += 1

    return new_answer


def get_case(dices: list):
    arr = []

    for case in product(*dices, repeat=1):
        arr.append(sum(case))

    return arr