class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows=defaultdict(set)
        cols=defaultdict(set)
        square=defaultdict(set)
        for row in range (9):
            for column in range (9):
                if board[row][column]==".":
                    continue
                if (board[row][column] in rows[row] 
                or board[row][column] in cols[column] 
                or board[row][column] in square[(row//3),(column//3)]):
                    return False
                rows[row].add(board[row][column])
                cols[column].add(board[row][column])
                square[(row//3),(column//3)].add(board[row][column])
        return True

                

        