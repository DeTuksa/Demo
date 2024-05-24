package business.core

import common.Context
import common.putData
import common.getData

const val APP_DATASTORE = "dev.tuksa.demo"
class AppDataStoreManager(private val context: Context): AppDataStore {
    override suspend fun setValue(key: String, value: String) {
        context.putData(key, value)
    }

    override suspend fun readValue(key: String): String? {
        return  context.getData(key)
    }
}