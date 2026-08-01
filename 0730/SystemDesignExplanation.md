# 系統設計與資料結構選擇說明

## 1. 書籍主要清單儲存
* 檔案與方法：`LibraryManagementSystem.java` - `books` 欄位 (`ArrayList<Book>`)
* 使用結構：`ArrayList`
* 選擇原因：需要隨機存取支援排序演算法與二分搜尋，時間複雜度為 O(1)。
* 未採用方法：若採用 `LinkedList`，二分搜尋時指標移動會退化至 O(N)。

## 2. 待維修工作排隊
* 檔案與方法：`RepairSchedulingSystem.java` - `waitQueue` 欄位 (`Queue<RepairTask>`)
* 使用結構：`Queue`
* 選擇原因：遵循先進先出原則，確保任務依報修順序處理。
* 未採用方法：若採用 `Stack` 會造成後進先出，導致早期提交的工作遭受飢餓。

## 3. 完成維修歷史記錄與復原
* 檔案與方法：`RepairSchedulingSystem.java` - `completedStack` 欄位 (`Stack<RepairTask>`)
* 使用結構：`Stack`
* 選擇原因：支援後進先出，適合處理最近完成紀錄的查詢與復原操作。
* 未採用方法：一般 List 搜尋最近一筆操作需要頻繁計算末端索引。

## 4. 依借閱次數/優先度排序
* 檔案與方法：`RepairAlgorithms.java` - `mergeSortByPriorityDesc()`
* 使用結構：歸併排序 (Merge Sort)
* 選擇原因：最壞時間複雜度為 O(N log N)，具有穩定性，能保證相同等級任務維持順序。
* 未採用方法：快速排序最壞時間複雜度可能退化至 O(N^2) 且為不穩定排序。

## 5. 依書籍編號查詢
* 檔案與方法：`BookAlgorithms.java` - `binarySearchById()`
* 使用結構：二分查找 (Binary Search)
* 選擇原因：對已排序的陣列搜尋效率極高，時間複雜度為 O(log N)。
* 未採用方法：順序查找在巨量資料下需要 O(N) 的時間。

## 6. 依書名/設備關鍵字模糊搜尋
* 檔案與方法：`BookAlgorithms.java` - `sequentialSearchByTitle()`
* 使用結構：順序查找 (Sequential Search)
* 選擇原因：比對包含子字串的多筆結果，順序走訪可確保不遺漏。
* 未採用方法：二分查找僅適用於單一精確比對且必須完成對應排序的 Key。