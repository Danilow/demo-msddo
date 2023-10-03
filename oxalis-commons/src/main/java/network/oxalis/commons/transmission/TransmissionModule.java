/*
 * Copyright 2010-2018 Norwegian Agency for Public Management and eGovernment (Difi)
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/community/eupl/og_page/eupl
 *
 * Unless required by applicable law or agreed to in
 * writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied.
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 */

package network.oxalis.commons.transmission;

import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import network.oxalis.api.settings.Settings;
import network.oxalis.api.transmission.TransmissionVerifier;
import network.oxalis.commons.guice.ImplLoader;
import network.oxalis.commons.guice.OxalisModule;

/**
 * @author erlend
 * @since 4.0.0
 */
public class TransmissionModule extends OxalisModule {

    @Override
    protected void configure() {
        bindSettings(TransmissionConf.class);

        bindTyped(TransmissionVerifier.class, DefaultTransmissionVerifier.class);
    }

    @Provides
    @Singleton
    protected TransmissionVerifier getInboundVerifier(Injector injector, Settings<TransmissionConf> settings) {
        return ImplLoader.get(injector, TransmissionVerifier.class, settings, TransmissionConf.VERIFIER);
    }
}
