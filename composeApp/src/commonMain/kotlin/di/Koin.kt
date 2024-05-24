package di

import common.Context
import org.koin.dsl.module
import presentation.SharedViewModel

fun appModule(context: Context) = module {
//    single { Json { isLenient = true; ignoreUnknownKeys = true } }
    factory {SharedViewModel(get())}
}