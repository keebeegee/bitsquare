/*
 * This file is part of Bitsquare.
 *
 * Bitsquare is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bitsquare is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bitsquare. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bitsquare.trade.protocol.availability.messages;

import io.bitsquare.app.Capabilities;
import io.bitsquare.app.Version;
import io.bitsquare.common.crypto.PubKeyRing;
import io.bitsquare.p2p.messaging.SupportedCapabilitiesMessage;

import javax.annotation.Nullable;
import java.util.ArrayList;

// We add here the SupportedCapabilitiesMessage interface as that message always predates a direct connection 
// to the trading peer
public final class OfferAvailabilityRequest extends OfferMessage implements SupportedCapabilitiesMessage {
    // That object is sent over the wire, so we need to take care of version compatibility.
    private static final long serialVersionUID = Version.P2P_NETWORK_VERSION;

    private final PubKeyRing pubKeyRing;
    public final long takersTradePrice;
    @Nullable
    private ArrayList<Integer> supportedCapabilities = Capabilities.getCapabilities();

    public OfferAvailabilityRequest(String offerId, PubKeyRing pubKeyRing, long takersTradePrice) {
        super(offerId);
        this.pubKeyRing = pubKeyRing;
        this.takersTradePrice = takersTradePrice;
    }

    @Override
    @Nullable
    public ArrayList<Integer> getSupportedCapabilities() {
        return supportedCapabilities;
    }

    public PubKeyRing getPubKeyRing() {
        return pubKeyRing;
    }

    @Override
    public String toString() {
        return "OfferAvailabilityRequest{" +
                "pubKeyRing=" + pubKeyRing +
                "} " + super.toString();
    }
}
