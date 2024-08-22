/*
 * Copyright 2022 Pera Wallet, LDA
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.algorand.android.modules.parity.data.di

import com.algorand.android.cache.SelectedCurrencyDetailSingleLocalCache
import com.algorand.android.modules.parity.data.mapper.CurrencyDetailDTOMapper
import com.algorand.android.modules.parity.data.repository.ParityRepositoryImpl
import com.algorand.android.modules.parity.domain.repository.ParityRepository
import com.algorand.android.network.MobileAlgorandApi
import com.algorand.android.exceptions.RetrofitErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class ParityRepositoryModule {

    @Provides
    @Named(ParityRepository.INJECTION_NAME)
    fun provideParityRepository(
        mobileAlgorandApi: MobileAlgorandApi,
        hipoApiErrorHandler: RetrofitErrorHandler,
        selectedCurrencyDetailSingleLocalCache: SelectedCurrencyDetailSingleLocalCache,
        currencyDetailDTOMapper: CurrencyDetailDTOMapper
    ): ParityRepository {
        return ParityRepositoryImpl(
            mobileAlgorandApi = mobileAlgorandApi,
            hipoApiErrorHandler = hipoApiErrorHandler,
            selectedCurrencyDetailSingleLocalCache = selectedCurrencyDetailSingleLocalCache,
            currencyDetailDTOMapper = currencyDetailDTOMapper
        )
    }
}
