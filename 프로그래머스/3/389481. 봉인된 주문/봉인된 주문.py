alpha = "abcdefghijklmnopqrstuvwxyz"

def solution(n, bans):
    length, num, word = get_length(n)

    # 길이 → 사전순 정렬
    bans = sorted(bans, key=lambda s: (len(s), s))
    # print(word)

    for b in bans:
        k = compare(word, b)  # word >= b 이면 다음 단어로 넘어감
        if k >= 0:
            n += 1
            length, num, word = get_length(n)
            # print(word)

    _, _, word_after = get_length(n)
    return word_after


def compare(a, b):  # a>b:1, a<b:-1, 같으면 0
    if len(a) != len(b):
        return 1 if len(a) > len(b) else -1
    # 파이썬 비교를 활용하면 깔끔
    return (a > b) - (a < b)


# ✅ 1-기반 26진수: 1->a, 26->z, 27->aa, 52->az, 53->ba, 702->zz, 703->aaa
def num_to_word(n: int) -> str:
    s = []
    while n > 0:
        n -= 1              # 1-기반 보정
        s.append(alpha[n % 26])
        n //= 26
    return "".join(reversed(s))

def get_length(num: int):
    word = num_to_word(num)
    return len(word), num, word
    