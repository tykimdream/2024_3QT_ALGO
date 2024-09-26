list = [int(input()) for i in range(9)]

total = sum(list)
# 결국 2명은 거짓, 다 돌면서 2명 빠질때 100이 되는 경우를 찾자

for i in range(9):
    for j in range(i+1, 9):
        # if ((total - list[i] - list[j]) == 100):
        if 100 == total-(list[i]+list[j]):
            num1, num2 = list[i], list[j]

            list.remove(num1)
            list.remove(num2)
            list.sort()

            for i in range(len(list)):
                print(list[i])
            break

    if len(list) < 9:
        break